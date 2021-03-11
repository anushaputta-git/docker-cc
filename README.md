# Cloud Computing 2211-1_20CS5165001 AssignmentsHomework#2 Dockers

•	Dockerfile has the code to cofigure docker image. Code is writtten in java. So, a docker openjdk8 image is created.
•	WordCounter.java will list the files in folder /home/data on the docker container. Each file in the folder /home/data will be read line by line and the word count and total word count is claculated. Logic to get the file with maximum word count is also written. Finally the IP of the host machine will be read. All the information will be written to a result.txt file which will be placed in the folder /home/output. Finally the contents written to the result.txt file will be printed on the console.

Assumptions made:
1.	Only space is considered as delimiter for words in text file
2.	Program supports reading text files alone
3.	Used Alpine to have a smaller image size

Steps to run the docker image:
•	Download the tar file 
•	Open command prompt in the directory in which the tar file is present
•	Assuming docker is pre-installed on the machine, run the below command to load the image from tar file
docker load -i anusha-docker-latest.tar
•	Once the above command runs successfully you should be able to see the below message
	Loaded image: anusha-docker-app:latest
•	Run the below command to execute the image
	docker run -it -v "Replace this with your local directory which has text files":/home/data anusha-docker-app:latest

Commands to create the docker image and tar:
• docker build -t anusha-docker-app:latest .
• docker save -o anusha-docker-latest.tar anusha-docker-app:latest
• docker load -i anusha-docker-latest.tar

Other Commands:
-> To check the images on docker
docker images
-> To remove an image
docker rmi -f anusha-docker-app:latest(image name or id can be used)


