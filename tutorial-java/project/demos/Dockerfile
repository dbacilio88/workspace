# Use a Gradle image to build the application:
FROM gradle:jdk-21-and-23-graal-jammy AS bilder

# Set the working directory inside the builder stage
WORKDIR /workspace

# Copy the project files
COPY . .

# build application with native profile
#RUN chmod +x gradlew && ./gradlew nativeCompile

# Use lightweight image to run the application
#FROM debian:bookworm-slim

# Set the working directory
#WORKDIR /app

# Copy build native imagen from builder stage
#COPY --from=bilder /workspace/build/native/nativeCompile /app/

# Ensure the executable  has the right permissions
#RUN ls /app

#RUN chmod +x /app/demos