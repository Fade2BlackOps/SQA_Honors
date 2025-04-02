import os
import re

# Define the mapping of old package names to new package names
package_map = {
    "classes": "com.yourcompany.bookstore.models",
    "classes.payment": "com.yourcompany.bookstore.models.payment",
    "classes.shipping": "com.yourcompany.bookstore.models.shipping",
    "interfaces": "com.yourcompany.bookstore.interfaces",
    "enums": "com.yourcompany.bookstore.enums",
    "services": "com.yourcompany.bookstore.services",
    "repositories": "com.yourcompany.bookstore.repositories",
    "controllers": "com.yourcompany.bookstore.controllers",
    "utils": "com.yourcompany.bookstore.utils"
}

# Base directory where Java files are stored
base_dir = "src/main/java/"

def update_package(file_path):
    """Update the package declaration in a Java file."""
    with open(file_path, "r", encoding="utf-8") as file:
        lines = file.readlines()

    new_lines = []
    for line in lines:
        match = re.match(r"^\s*package\s+([\w\.]+);", line)
        if match:
            old_package = match.group(1)
            if old_package in package_map:
                new_package = package_map[old_package]
                line = f"package {new_package};\n"
        new_lines.append(line)

    with open(file_path, "w", encoding="utf-8") as file:
        file.writelines(new_lines)

def process_java_files(directory):
    """Recursively update package declarations in all Java files."""
    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith(".java"):
                file_path = os.path.join(root, file)
                update_package(file_path)

# Run the script
process_java_files(base_dir)

print("Package names updated successfully!")
