# TerryChatBot
TerryChatBot is a Java-based chatbot designed to help students at the Terry College of Business easily discover student organizations that align with their interests, schedules, and goals. By centralizing club information and offering a conversational interface, this tool reduces the time and effort required to find the right organization—and helps students avoid missing important deadlines.

# Problem Statement
Many Terry College students struggle to find clubs that match their career goals, schedules, and preferences. Information is often scattered across different websites, and deadlines can be easily missed. TerryChatBot solves this by acting as a centralized, intelligent assistant for student involvement.

# Solution
This project includes:

- A centralized database of all Terry College organizations

- A chatbot interface that asks users about:

- Career interests

- Preferred meeting times

- Membership process (e.g., interviews)

- MISTERS credit requirements

- Personalized recommendations based on user input

# Technologies Used
- Java (JDK 17+ recommended)

- Object-Oriented Programming (OOP)

- File I/O and data filtering

- [Optional] JavaFX or Swing for GUI (if applicable)

# How to Run
- Clone the repository or download the .java and .class files.

- Compile (if source code is available):

bash

Copy

Edit

javac ClubLoader.java Main.java

Run the main class:


bash

Copy

Edit

java Main


If your main file has a different name, replace Main with the correct class name.

# Data Structure
The backend reads from a database (e.g., CSV, JSON, or flat file) that contains:

- Club Name

- Description

- Meeting Times

- Career Paths

- Membership Process

- Major Requirements

- MISTERS Credit Eligibility

- Contact Info

# Folder Structure

bash

Copy

Edit

/src

  ├── Club.java
  
  ├── ClubLoader.java
  
  ├── ChatBot.java
  
  └── Main.java
/data

  └── clubs.csv
  
Note: Folder structure may vary based on your setup.

# Future Plans
Integration into UGA's eLC platform

Enhanced GUI or web-based frontend

Support for real-time Q&A about club deadlines and requirements

# License
This project is licensed under the MIT License. See the LICENSE file for details.
