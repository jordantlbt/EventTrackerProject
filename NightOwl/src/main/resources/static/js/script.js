console.log("script is loaded");

window.addEventListener("load", function (e) {
  console.log("document loaded");
  init();
});

function init() {
  console.log("In init");
  getAllMovies();
}

function getAllMovies() {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", `api/movies`);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let movies = JSON.parse(xhr.responseText);
        displayAllMovies(movies);
      }
    }
  };
  xhr.send();
}

function displayAllMovies(movies) {
  var dataDiv = document.getElementById("moviesList");
  dataDiv.textContent = "";
 

  let table = document.createElement("table");
  dataDiv.appendChild(table);
  table.style.border = '3px solid black';
  let thead = document.createElement("thead");
  table.appendChild(thead);
  let thr = document.createElement("tr");
  thead.appendChild(thr);
  let th1 = document.createElement("th");
  th1.textContent = "Title";
  thead.appendChild(th1);
  let th2 = document.createElement("th");
  th2.textContent = "Season";
  thead.appendChild(th2);
  let th3 = document.createElement("th");
  th3.textContent = "Episode";
  thead.appendChild(th3);
  let th4 = document.createElement("th");
  th4.textContent = "Have Seen";
  thead.appendChild(th4);
  let th5 = document.createElement("th");
  th5.textContent = "Date Watched";
  thead.appendChild(th5);
  let th6 = document.createElement("th");
  th6.textContent = "Date Plan to Watch";
  thead.appendChild(th6);
  let th7 = document.createElement("th");
  th7.textContent = "Snacks";
  thead.appendChild(th7);
  let tbody = document.createElement("tbody");
  table.appendChild(tbody);

  for (let movie of movies) {
    let tr = document.createElement("tr");
    tbody.appendChild(tr);

	// let img = document.createElement('img');
	// img.src = movie.imageUrl;

	// let tdImage = document.createElement('td');
	// tdImage.textContent = img;
	// tr.appendChild(tdImage);

    let td1 = document.createElement("td");
    td1.textContent = movie.title;
    tr.appendChild(td1);
	td1.style.borderBottom = '1px solid black';
	td1.style.borderTop = '1px solid black';
	td1.style.borderRight = '1px solid black';

    let td2 = document.createElement("td");
    td2.textContent = movie.season;
    tr.appendChild(td2);
	td2.style.borderBottom = '1px solid black';
	td2.style.borderTop = '1px solid black';
	td2.style.borderRight = '1px solid black';

    let td3 = document.createElement("td");
    td3.textContent = movie.episode;
    tr.appendChild(td3);
	td3.style.borderBottom = '1px solid black';
	td3.style.borderTop = '1px solid black';
	td3.style.borderRight = '1px solid black';

	let td4 = document.createElement('td');
    td4.textContent = movie.haveWatched;
	tr.appendChild(td4);
	td4.style.borderBottom = '1px solid black';
	td4.style.borderTop = '1px solid black';
	td4.style.borderRight = '1px solid black';

	let td5 = document.createElement('td');
    td5.textContent = movie.dateWatched;
	tr.appendChild(td5);
	td5.style.borderBottom = '1px solid black';
	td5.style.borderTop = '1px solid black';
	td5.style.borderRight = '1px solid black';

	let td6 = document.createElement('td');
    td6.textContent = movie.dateScheduled;
	tr.appendChild(td6);
	td6.style.borderBottom = '1px solid black';
	td6.style.borderTop = '1px solid black';
	td6.style.borderRight = '1px solid black';

	let td7 = document.createElement('td');
    td7.textContent = "snack data here"
	tr.appendChild(td7);
	td7.style.borderBottom = '1px solid black';
	td7.style.borderTop = '1px solid black';
	
  }
}


