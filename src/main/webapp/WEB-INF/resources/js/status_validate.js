function statusAll() {
	var table, tr, td, i;
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[8];
		if (td) {
			tr[i].style.display = "";

		}
	}
}

function statusOpen() {
	var input, table, tr, td, i;
	input = document.getElementById("open").innerHTML;
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[8];
		if (td) {
			if (td.innerHTML.indexOf(input) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}
function statusAccepted() {
	var input, table, tr, td, i;
	input = document.getElementById("accepted").innerHTML;
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[8];
		if (td) {
			if (td.innerHTML.indexOf(input) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}
function statusRejected() {
	var input, table, tr, td, i;
	input = document.getElementById("rejected").innerHTML;
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[8];
		if (td) {
			if (td.innerHTML.indexOf(input) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}