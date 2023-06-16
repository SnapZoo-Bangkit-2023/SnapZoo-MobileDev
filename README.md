# SnapZoo, Indonesian Zoo App

## Team C23-PS157 Contributors
* Angger Muhammad Rizqi (M286DKX3783) - [GitHub@Anggerm](https://github.com/Anggerm) - Machine Learning - Universitas Negeri Semarang
* Bahtiar Hasan (C172DSX3347) - [GitHub@bhtiar](https://github.com/bhtiar) - Cloud Computing - Universitas Gunadarma
* Dyah Nabila Yulianto (M286DSY0323) - [GitHub@dyahnabila-y](https://github.com/dyahnabila-y) - Machine Learning - Universitas Negeri Semarang
* Hafidzurrohman Saifullah (C172DKX4931) - [GitHub@Hafidzurr](https://github.com/Hafidzurr) - Cloud Computing - Universitas Gunadarma
* Muhammad Prasetyo Nugroho (M282DSX1345) - [GitHub@MuhammadPrasetyoN](https://github.com/MuhammadPrasetyoN) - Machine Learning - Universitas Negeri Malang
* Natasya Wulandari (A172DSY4927) - [GitHub@natasyaawldr](https://github.com/natasyaawldr) - Mobile Development - Universitas Gunadarma

## About
The Snapzoo application is an application based on animal identification through photo activities, which can help zoo visitors learn about wild animals in a more interactive and fun way. Using image recognition technology, users can photograph animals encountered in zoos and the application will identify the type of animal and provide detailed information about the habitat, behavior and unique characteristics of the animal.

## Presentation and Demo Video
```
https://youtu.be/vakn7XCVNcQ
```
```
https://drive.google.com/file/d/1jHuIgz3R2qQDRKMnDD7d9TuOc3eWEwGY/view
```

## Android APK File (Minimum Android SDK 21)
```
https://drive.google.com/drive/folders/1fnTmL0c1Yma-tWOXsn2Nt3QHWrhdPydq?usp=sharing
```
```
https://drive.google.com/file/d/1wEgEgqXRE0PMQ8Sx2YOp8X5kZjjquQ5L/view?usp=sharing
```

## Wireframe & Mock-Up
```
https://www.figma.com/file/nU6gWLv3l2B0C3MaX4FFeV/SnapZoo?type=design&node-id=0-1
```

## REST API Documentation
```
https://www.postman.com/docking-module-meteorologist-46121606/workspace/snapzoo-api/collection/26452276-61d1bd2d-87b6-402f-a644-1d41ba32edfc?action=share&creator=26452276
```

## App Features
![Feature 1](https://github.com/SnapZoo-Bangkit-2023/SnapZoo-Documentation/blob/2fe65213371f1b405807c890dc68bb01843ebcb4/asset/feature_1.png)
![Feature 2](https://github.com/SnapZoo-Bangkit-2023/SnapZoo-Documentation/blob/7999a4a10857d82e956ecb48891a276188619374/asset/feature_2!.png)
![Feature 3](https://github.com/SnapZoo-Bangkit-2023/SnapZoo-Documentation/blob/7999a4a10857d82e956ecb48891a276188619374/asset/feature_3!.png)
![Feature 4](https://github.com/SnapZoo-Bangkit-2023/SnapZoo-Documentation/blob/7999a4a10857d82e956ecb48891a276188619374/asset/feature_4!.png)

* The SnapZoo application is specifically designed for users who want to identify and learn about animals they encounter in the zoo.
* Upload image from camera to predict its animal you wanna know.
* Search various Animal in Zoo by typing on search bar.
* Information about Animal inclunding name, classification, images, and other related about animal.

## Technology
* Android Studio IDE to develop the Android application.
* Google Cloud Platform as deployment platform for REST API and ML model.
* Tensorflow and Keras to develop, train, and deploy ML model.

## Integration Method
SnapZoo consists of three components, Android, Cloud Computing, and Machine Learning. Basically, to integrate these, Cloud Computing acts as service to bridge communication between Android and Machine Learning. Here is a simple illustration on how our integration method works.
![Integration Method](https://github.com/SnapZoo-Bangkit-2023/SnapZoo-Documentation/blob/145eacf6fa6b8aed60850776c5397476dffe36d4/asset/integration!.png)
Integration method explanation:
1. The Android app allows users to capture a picture of an animal they encounter.
2. The App Engine, which serves as a service, handles the requests from the app.
3. Depending on the request, the App Engine services access the REST API. If the request is for animal description information, it queries the pre-existing JSON data in the App Engine. If the request is for animal image prediction, the image is sent to the ML model.
4. Once the REST API has finished processing, the App Engine services return the results as JSON literals to the Android app. This includes the prediction result and the animal description.
5. The Android app processes the received JSON literals and displays the relevant information to the user.

## Estimate Google Cloud Platform Pricing
![GCP Pricing](https://github.com/SnapZoo-Bangkit-2023/SnapZoo-Documentation/blob/0bf7917c6f16f013c44dab1d330867d70e8aeaf4/asset/GCP_pricing.png)

## Android Studio Project Installation
### Components
SnapZoo Android app is developed using Android Studio IDE. Here are components that we used.
* Utilizing Kotlin language in its development
* Implementing Bottom Navigation to navigate to Home Screen, Scan Screen, and Search Screen
* Utilizing RecyclerView to display a list of animals
* Implementing Search View functionality to search for animals based on user input
* Integrating CameraX as a camera feature to capture animal images
* Utilizing Retrofit library for network requests

### Requirements
* Android Studio Electric Eel | 2022.1.1 Patch 2
* Minimum Android SDK 21 

### Workflow
#### 1. Clone The Project and Open It in Android Studio
```
git clone https://github.com/SnapZoo-Bangkit-2023/SnapZoo-MobileDev.git
```
#### 2. Run or Build The App
  run the app, open the project in Android Studio and wait for Gradle to finish building. Then, you can run the application by either clicking "Run 'app'" or using the    shortcut Shift+F10.

## Cloud Computing Project Installation
### Components and Requirements
* Firebase Project and Firebase Storage For Put The Folder Animal Photo.
* REST API developed using Flask.
* Deployed REST API running as service on Google App Engine with Model ML(h5) and JSON Description.
### Workflow
#### 1. Clone The Project and Open It in Your Favorite IDE And Make a Firebase Project

```
git clone https://github.com/SnapZoo-Bangkit-2023/SnapZoo-CloudComputing.git
```
```
https://firebase.google.com/
```
* Make a folder "foto" in firebase storage and put all foto in that's folder.
* Change The URL Link Animal Image You Already Take it From Firebase Storage or foto folder in Description.json (make sure you open first the image in browser and take the long url).
#### 2. Try to Running The RestAPI in Local
* Open The folder RestAPI You Already Clone in Your Visual Studio Code. 
* Open New Terminal `Install Flask"pip install flask" -> Run the main.py -> "python main.py"` (make sure other library like pillow, and kerastenserflow already install in your local).
* Choose `Generate New Private Key`, and your private key JSON file will be downloaded.
* Open Postman and test the URLBASE `For Predict put /predict in last URLBASE "Use Post -> key"file"-> and put animal image` and `For Description put /deskripsi in last URLBASE "Use Get -> Send`
#### 3. Deploy REST API to App Engine
* Drag and drop RestAPI-SnapZoo folder to Cloud Shell Editoe(make sure you already change url image from From Firebase Storage or foto folder in Description.json and Model ML h5 in same folder with main.py).
* Enabling App Engine In your Google Console Account.
* Direct to RestApi Folder and Deploy the RestAPI in right directory path.
#### Our Deployed REST API URL
Please head to this link for our detailed REST API documentation.
```
https://www.postman.com/docking-module-meteorologist-46121606/workspace/snapzoo-api/collection/26452276-61d1bd2d-87b6-402f-a644-1d41ba32edfc?action=share&creator=26452276
```

## Machine Learning Project Installation
### Building The Model 
* Preparing the image from dataset
* Image pre-processing
* Image Augmentation
* Convolutional Neural Network (CNN)
* Transfer Learning (InceptionV3)
* Callback
* Train the model
* Plot the Accuracy and Loss
* Evaluate the model
* Test the model
* Save the Model

### Requirements
* [Google Colaboratory](https://colab.research.google.com/) or [Jupyter Notebook](https://jupyter.org/install).
* Animal SnapZoo Dataset.
* Latest Tensorflow Version 2.12.0.
* Python Version 3.6 or above.

### Dataset
* [Animal Image Dataset](https://www.kaggle.com/datasets/antoreepjana/animals-detection-images-dataset)
<p align="center"> <img src="https://github.com/SnapZoo-Bangkit-2023/SnapZoo-Documentation/blob/49635f19f2c12cf3bacd3322e32cba612d880718/asset/dataset.png"></p>
<p align="center">Dataset Preview</p>
<p align="center">(Left to right) badak, gajah, harimau, jerapah, monyet, penguin, rusa, singa, ular, dan zebra</p>

### Workflow
1. Get the dataset and save in drive or local.
2. Open the .ipynb file in Google Colab or Jupyter Notebook.
3. if using colab, click Copy to Drive or file -> save a copy in Drive. this will allow you to edit and run  the .ipynb file in your drive without edit the original file.
4. Run every cell in the .ipynb file.
5. Download and save the .h5 and tflite model in your drive by clicking the cell in ‘Save Model’ part (the model will be automatically save in'/content/drive/MyDrive/YourModel.tflite' path.).

