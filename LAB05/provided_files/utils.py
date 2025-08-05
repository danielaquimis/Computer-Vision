import os
import shutil
import zipfile
from datetime import datetime
from pathlib import Path
from zipfile import ZipFile
from base64 import b64encode
import numpy as np
from tracking import BoundingBox
import cv2


# this function reads a video and outputs the list of frames in RGB
def read_video(filepath, num_frames=None):
    cap = cv2.VideoCapture(filepath)
    
    total_num_frames = int(cap.get(cv2.CAP_PROP_FRAME_COUNT))
    if num_frames:
        num_frames = min(num_frames, total_num_frames)
    else:
        num_frames = total_num_frames
    
    frames, i = [], 0
    while cap.isOpened() and i < num_frames:
        ret, frame = cap.read()
        if ret:
            gray_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
            frames.append(gray_frame)
        else:
            break
        i += 1
    cap.release()
    return frames


def display_video(video_path, width=480, height=360):
    from IPython.display import HTML
    video_file = open(video_path, "r+b").read()
    video_url = f"data:video/mp4;base64,{b64encode(video_file).decode()}"
    return HTML(f"""<video width={width} height={height} controls><source src="{video_url}"></video>""")


def load_semantic_segmentation(semantic_seg_path, score_threshold):
    semantic_seg = np.load(semantic_seg_path, allow_pickle=True)

    bboxes, masks = [], []
    for i in range(len(semantic_seg)):
        frame_bboxes, frame_masks = [], []
        for bb, mask, score in zip(semantic_seg[i]['boxes'],
                                   semantic_seg[i]['masks'],
                                   semantic_seg[i]['scores']):
            if score > score_threshold:
                frame_bboxes.append(BoundingBox(bb))
                frame_masks.append(mask)

        bboxes.append(frame_bboxes)
        masks.append(frame_masks)
    return bboxes, masks


def plot_similarity_matrix(matrix, figsize=(7,7)):
    import matplotlib.pyplot as plt
    
    fig, ax = plt.subplots(figsize=(7,7))
    cax = ax.matshow(matrix, cmap=plt.cm.Reds)
    fig.colorbar(cax)
    for element in range(matrix.size):
        i, j = np.unravel_index(element, matrix.shape)
        ax.text(j, i, f'{matrix[i,j]:.1f}', va='center', ha='center')
    plt.xlabel('Next Bounding Boxes', fontsize=16)
    plt.ylabel('Previous Detection Boxes', fontsize=16)
    ax.xaxis.tick_top()
    ax.xaxis.set_label_position('top')
    plt.show()
