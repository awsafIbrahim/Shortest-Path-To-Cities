Notes:
a.  If you are using a Mac, you have a unix system already.  You run 
    Terminal.app and do everything locally instead of using a remote
    unix server.

b. You should be able to run these using Git bash on Windows

c.  You can run the tests inside your IDE, but you will need to copy
    and paste the input file into the console and then visually inspect
    the output.  This is workable for the short small tests, but is
    less workable for the larger ones. 

d. If you have trouble running the test script then you can follow the
second instructions further below to run it on an FCS unix server.

To run these tests locally:

1. Copy your Java program to this directory.

2a. Run the script file to run the tests.

     ./test.sh

2b. If a test fails, you have see the differences in output by running in
    debug mode.

     ./test.sh debug


To run these tests on the Faculty server:

0. Be sure your CS id is activated.  If it is not, you can go to the
   CS Help Desk or look here: 
   https://www.dal.ca/faculty/computerscience/current/getting_set_up.html

1. Copy your Java program to this directory.

2. Compress the input_tests directory on your local machine

      zip input_tests.zip input_tests/*

  Alternatively, you may be able to right-click on the input_tests
	folder in your file browser and select a compression option. If you do
	not know how to do this, there are tutorials on the web on how to
	compress a folder or files.

1. Log into the Faculty unix server.
     timberlea.cs.dal.ca

   You will need to use an ssh client such as ssh (Mac)  or 
   Putty (Windows).

   Note: You will need your CS id and password to log into these servers.

   If you do not know how to do this, there are plenty of tutorials on
   the web on how to ssh into a unix server.

2. Create a csci2134 directory and an assn3 subdirectory on the unix server

      mkdir -p csci2134/assn3

3. Change directories into assn3

      cd csci2134/assn3

4. Copy (upload) the input_tests.zip file to csci2134/assn3 on the Faculty unix 
   server.

   Again, if you do not know how to do this, there are plenty of tutorials 
   on the web on how to copy files to a unix server.

5. On the unix server, unzip the zip file.

     unzip input_tests.zip

6. Copy (upload) your Java program to csci2134/assn3 on the Faculty unix 
   server.

7a. Run the script file to run the tests.

     ./test.sh

7b. If a test fails, you have see the differences in output by running in
    debug mode.

     ./test.sh debug

