#!/bin/bash
# Author: Sergey Kostenko
# File for Insight Data Engineering
# Running WordCount and RunningMedian

# Set permission for the directory
chmod 777 src

# Changing directory to src
cd ./src

# Set proper permissions
chmod 777 WordCount.java
chmod 777 RunningMedian.java

# Compile and run Word Count
echo "Compile and run Word Count..."
javac WordCount.java
java WordCount

# Compile and run Running Median
echo "Compile and run Running Median..."
javac RunningMedian.java
java RunningMedian

echo "Done!"
