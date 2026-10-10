# Java + HTML/CSS + Maven + Jenkins Declarative Pipeline

A beginner-friendly sample project for practicing GitHub, Maven, and Jenkins on an AWS EC2 server.

## Project features

- Java 21 application entry point
- Responsive HTML/CSS landing page generated into `target/site/index.html`
- JUnit 5 test
- Maven build (`pom.xml`)
- Jenkins Declarative Pipeline (`Jenkinsfile`)
- JAR artifact archived by Jenkins

## Project structure

```text
java-maven-jenkins-sample/
├── pom.xml
├── Jenkinsfile
├── README.md
├── .gitignore
└── src/
    ├── main/java/com/example/App.java
    └── test/java/com/example/AppTest.java
```

## Requirements

- JDK 21
- Maven 3.8 or newer
- Git
- Jenkins with Pipeline and JUnit plugins

## Run locally

```bash
mvn clean test package
java -jar target/java-maven-jenkins-sample-1.0.0.jar
```

The application generates `target/site/index.html`. Open that HTML file in your browser.

## Publish to GitHub

1. Create a new, empty GitHub repository named `java-maven-jenkins-sample`.
2. Extract this project ZIP.
3. Open a terminal in the extracted project folder and run:

```bash
git init
git add .
git commit -m "Add Java Maven Jenkins sample application"
git branch -M main
git remote add origin https://github.com/YOUR_GITHUB_USERNAME/java-maven-jenkins-sample.git
git push -u origin main
```

Replace `YOUR_GITHUB_USERNAME` with your GitHub username. Do not commit passwords, tokens, or AWS keys.

## Run it in Jenkins

1. Confirm Maven and JDK are installed on the Jenkins agent.
2. In Jenkins, choose **New Item**.
3. Enter `Java-Maven-Declarative-Pipeline`.
4. Select **Pipeline** and click **OK**.
5. Under **Pipeline**, choose **Pipeline script from SCM**.
6. Select **Git**, paste your repository URL, set branch to `*/main`, and set script path to `Jenkinsfile`.
7. Save, then click **Build Now**.
8. Open **Console Output** to see Checkout, Build, Test, Package, and Generate HTML stages.

### EC2 note

This Jenkinsfile uses `sh` commands and assumes Maven and JDK 21 are available on the Jenkins build agent. If the agent is the EC2 controller itself, install/configure them there. For a production Jenkins setup, use a separate build agent and avoid running builds on the controller.

The generated HTML is archived as a Jenkins build artifact; it is not automatically published as a public website.
