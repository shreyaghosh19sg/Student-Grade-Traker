let grades = [];

function addGrade() {
  const gradeInput = document.getElementById("gradeInput");
  const grade = parseFloat(gradeInput.value);
  if (isNaN(grade) || grade < 0 || grade > 100) {
    alert("Please enter a valid grade between 0 and 100.");
  } else {
    grades.push(grade);
    alert("Grade added successfully.");
    gradeInput.value = "";
  }
}

function displayGrades() {
  const output = document.getElementById("output");
  if (grades.length === 0) {
    output.innerHTML = "<p>No grades entered yet.</p>";
    return;
  }
  let html = "<h3>Grades Entered:</h3><ul>";
  grades.forEach((grade, index) => {
    html += `<li>Student ${index + 1}: ${grade.toFixed(2)}</li>`;
  });
  html += "</ul>";
  output.innerHTML = html;
}

function showStatistics() {
  const output = document.getElementById("output");
  if (grades.length === 0) {
    output.innerHTML = "<p>No grades to show statistics.</p>";
    return;
  }

  const sum = grades.reduce((a, b) => a + b, 0);
  const avg = sum / grades.length;
  const max = Math.max(...grades);
  const min = Math.min(...grades);

  output.innerHTML = `
    <h3>Statistics:</h3>
    <p>Average Grade: ${avg.toFixed(2)}</p>
    <p>Highest Grade: ${max.toFixed(2)}</p>
    <p>Lowest Grade: ${min.toFixed(2)}</p>
  `;
}

function clearGrades() {
  grades = [];
  document.getElementById("output").innerHTML = "<p>All grades cleared.</p>";
}
