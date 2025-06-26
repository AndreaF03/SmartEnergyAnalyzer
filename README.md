## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.
# SmartEnergyAnalyzer

A Java-based application that analyzes hourly energy consumption data and visualizes trends using web-based charts. Ideal for power grid efficiency studies, sustainability research, or smart energy system monitoring.

Built by Andrea Fernandes, Data Science student passionate about energy analytics and intelligent systems.

---

## Features

- Analyzes large-scale hourly energy usage data
- Calculates:
  - Average and peak usage
  - Usage by hour, day, and month
- Exports analysis to:
  - `report.txt` (readable summary)
  - `avg_by_hour.json` (for charting)
- Displays interactive hourly bar charts using a simple frontend

---

## Technologies Used

| Layer        | Technology                    |
|--------------|-------------------------------|
| Backend      | Java, GSON (JSON library)     |
| Frontend     | HTML, JavaScript, Chart.js    |
| Data Source  | [Hourly Energy Dataset on Kaggle](https://www.kaggle.com/datasets/robikscube/hourly-energy-consumption)
| IDE          | Visual Studio Code            |
| Versioning   | Git and GitHub                |

---
## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
