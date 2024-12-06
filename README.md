# README

## Project: HTML Document Analysis with Jsoup

This Java project uses the Jsoup library to extract and analyze information from HTML documents. It allows users to input a URL and provides statistics and details about the HTML document's content, such as the number of lines, paragraphs, images within paragraphs, forms, and their input fields.

### Features

The program performs the following functions:

1. **Count Lines**: Indicates the number of lines in the returned HTML resource.
2. **Count Paragraphs**: Indicates the number of paragraphs (`<p>`) present in the document.
3. **Count Images in Paragraphs**: Counts the number of images (`<img>`) inside the paragraphs of the HTML.
4. **Count Forms**: Categorizes and counts the number of forms (`<form>`) by method (POST or GET).
5. **Show Form Fields**: For each form, displays the `<input>` fields and their respective types.
6. **Send POST Request**: For forms using the POST method, sends a request to the server with specific parameters and displays the response.

### Requirements

- Java 8 or higher
- Jsoup library

### Installation

1. Clone this repository to your local machine.
2. Ensure that you have Java installed.
3. Add the Jsoup library to your project. You can do this by downloading the JAR from [Jsoup] or using a dependency manager like Maven or Gradle.

### Running the Program

To run the program, you can use the following command from the command line:

```bash
javac -cp jsoup.jar edu/pucmm/ce/main/Main.java
java -cp .:jsoup.jar edu.pucmm.ce.main.Main
```

### Test Examples

You can test the program using the following URLs:

- [Create a Free Website]
- [Article on Xataka]
- [Register Your Samsung Product]

### Notes

- Ensure that the URLs you input are valid and accessible.
- The program handles exceptions for invalid URLs and other connection errors.

### Contributions

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-new-feature`).
3. Make your changes and commit (`git commit -m 'Adding new feature'`).
4. Push to the branch (`git push origin feature-new-feature`).
5. Open a Pull Request.

### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
