This is a number guessing game made in Java.

Run client.java and server.java on 2 command line interfaces together. There are two entities server and client.

Process of game:

Client will connect with the server and send 4 values in arguments. First argument is maximum possible value (totally depends on client), second argument is maximum number of guesses allowed, third argument is server IP address and fourth argument is server Port Address.

Server will make a guess and the guessed value will be sent to client. 

Client will respond with appropriate digits on receiving the guess value. If the guessed value is less than original number, client will return -1 to server. If the guessed value is greater than original number, client will return 1 to server. If the server guesses the correct value, client will return 0.

Server will guess the number based on the input from the client.

This process will continue until the maximum number of guesses limit is reached or server guesses the correct answer, whichever happens first.

After server sends the number in the last attempt, client responds with the correct number and whether the server guessed it in last attempt or not.
