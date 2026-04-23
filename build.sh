#!/bin/sh

set -e

# create output directory if missing
mkdir -p out

echo "Compiling..."
# Compile all java files under src/main/java
find src/main/java -name "*.java" > sources.txt
javac -d out @sources.txt

echo "Running..."
java -cp out se.kth.iv1350.repairelectricbike.startup.Main
