# Maven Tomcat Hands-On

A small Java Servlet web application for practicing GitHub, Maven, Jenkins, and Apache Tomcat.

## Compatibility

- Java 17
- Maven 3.8+
- Apache Tomcat 9.x (uses `javax.servlet`)
- Produces a WAR file named `maven-tomcat-hands-on.war`

## Build locally

```bash
mvn clean package
```

Expected artifact:

```text
target/maven-tomcat-hands-on.war
```

## Run tests

```bash
mvn test
```

## Deploy manually to Tomcat 9

Copy `target/maven-tomcat-hands-on.war` to Tomcat's `webapps/` directory, then start/restart Tomcat if needed.

Open:

- `http://YOUR_TOMCAT_HOST:8080/maven-tomcat-hands-on/`
- `http://YOUR_TOMCAT_HOST:8080/maven-tomcat-hands-on/hello`

Replace `YOUR_TOMCAT_HOST` with your Tomcat server's IP or DNS name. Ensure the Tomcat port is reachable only from trusted networks.

## Upload to GitHub

1. Create an empty GitHub repository.
2. Extract this project folder.
3. From a terminal in this folder, run:

```bash
git init
git add .
git commit -m "Add Maven Tomcat hands-on project"
git branch -M main
git remote add origin https://github.com/YOUR_GITHUB_USERNAME/YOUR_REPOSITORY.git
git push -u origin main
```

Replace the remote URL with your repository URL. GitHub no longer accepts account passwords for Git over HTTPS; use a personal access token or SSH authentication when prompted.

## Jenkins practice

Create a Jenkins job that checks out your GitHub repository and runs:

```text
clean package
```

For a Freestyle job, choose the configured Maven installation and use `clean package` as the goals. Confirm the build produces `target/maven-tomcat-hands-on.war`.

For a deployment job, configure the deploy-to-container step with the WAR pattern:

```text
target/*.war
```

Use Tomcat Manager credentials stored in Jenkins Credentials; do not hard-code passwords in the repository. Configure Tomcat Manager access carefully and restrict network access.

## Troubleshooting

- If Maven says `JAVA_HOME` or Java version is wrong, compare `java -version` with `mvn -version` on the machine running the build.
- If no WAR is created, check that the Maven build reached `BUILD SUCCESS` and that `pom.xml` contains `<packaging>war</packaging>`.
- This sample uses `javax.servlet`, so it targets Tomcat 9. For Tomcat 10+, servlet packages changed to `jakarta.servlet`; this sample needs migration before use there.
