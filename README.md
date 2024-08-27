**Multi-Client Chat Application**

This repository contains a simple multi-client chat application built in Java. The application consists of three main components:

Server: Handles incoming client connections, manages client sessions, and broadcasts messages to all connected clients.

ClientHandler: Manages individual client connections, handles message sending and receiving, and maintains a list of connected clients.

Client: Represents the client-side application that connects to the server, sends messages, and listens for incoming messages.

**Project Structure**

Server.java: Implements the chat server that listens for incoming client connections on a specified port.

ClientHandler.java: Handles communication between the server and individual clients, including broadcasting messages and managing client sessions.

Client.java: Provides the client-side functionality to connect to the server, send messages, and receive messages from other clients.

**Prerequisites**

Java Development Kit (JDK) 8 or higher

An IDE (like IntelliJ IDEA or Eclipse) or a text editor

Basic understanding of Java and socket programming

**Setup and Usage**

**1. Clone the Repository**

bash

Copy code

**git clone https://github.com/your-username/multi-client-chat.git**

cd multi-client-chat

**2. Compile the Code**

Ensure you have Java installed and compile the Java files using the following commands:

bash

Copy code

javac Server.java

javac ClientHandler.java

javac Client.java

**3. Run the Server**

Start the server by executing the Server class. It will listen on port 5000 by default.

bash

Copy code

java Server

**4. Run the Clients**

Start multiple instances of the client by executing the Client class. Each client will prompt for a username and then allow sending and receiving messages.

bash

Copy code

java Client

**5. Interact with the Chat**

Enter a username when prompted by each client.

Type messages in the client console and press Enter to send them.

Messages from all clients will be broadcasted to everyone in the chat.

Features

Server-Side:

Accepts multiple client connections.

Broadcasts messages from one client to all other clients.

Notifies when a client joins or leaves the chat.

Client-Side:

Connects to the server and joins the chat.

Sends messages to the server.

Listens and displays incoming messages from other clients.

**Code Overview**

Server.java: Manages client connections and starts a new thread for each client using the ClientHandler class.

ClientHandler.java: Handles reading from and writing to the client, broadcasting messages, and managing client disconnections.

Client.java: Connects to the server, sends messages, and listens for messages from other clients.

**Contact**

For any questions or support, please open an issue in this repository or contact sumitk3022003@gmail.com.
