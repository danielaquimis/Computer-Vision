# Computer-Vision

📘 Lab 01 – Video Sampling & Frequency Analysis
🔍 Task 1 – 2D Sampling and Aliasing
Sampled a function ψ(x, y) using a defined lattice matrix.
Generated a 2D sampled grid and visualized both the signal and its frequency spectrum.
Analyzed the presence of aliasing by checking the frequency support against the Voronoi cell → ✔️ Aliasing exists.

🔍 Task 2 – Temporal Frequency in Video
Extracted pixel intensity over time at position (125,160).
Used FFT to find the dominant frequency: 4.4167 Hz.
Verified Nyquist rate → min. sampling: 8.83 Hz.
Downsampled video to 20 Hz → frequency recovered successfully.
Extended analysis to all pixels → found global max freq ≈ 9.08 Hz → min. frame rate ≈ 18 Hz.
Downsampled to 7.2 Hz (~40%) → observed aliasing artifacts (e.g., wagon-wheel effect, motion inversion).


📘 Lab 02 – Optical Flow
🎯 Goal
Understand and implement Lucas-Kanade optical flow.
Focused on assumptions, limitations (e.g., aperture problem, brightness constancy), and pyramid implementations.
🧪 Tasks
Prepared with theoretical resources: aperture effect, Taylor expansion, and Harris corner detection.
Built code to detect corners and apply optical flow estimation.
Utilized pyramidal approach for multi-scale motion analysis.
Emphasized proper commenting, visualization with plt.quiver, and consistency checking (e.g., forward-backward error).



📘 Lab 05 – Background Subtraction and Object Tracking
🎯 Goal
To implement background subtraction and apply Kalman filtering for robust object tracking in videos.
🧪 Task 1 – Background Subtraction
Used OpenCV’s MOG2 (cv2.createBackgroundSubtractorMOG2) to detect moving foreground objects.
Processed video frames to:
Apply background subtraction.
Perform thresholding and morphological operations to clean up noise.
Extract contours and draw bounding boxes around detected objects.
Demonstrated basic motion detection using a static camera.
🧪 Task 2 – Kalman Filter for Tracking
Initialized a Kalman filter to track a moving object:
State vector: position and velocity (x, y).
Applied predict and correct steps based on contour detection.
Visualized:
Predicted path (Kalman filter).
Actual object detection (bounding box).
Used different colors for prediction vs. actual detection.
Successfully tracked object movement across frames, even with occlusion or partial detection loss.
