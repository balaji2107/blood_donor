/**
 * 
 */
var addUser = document.getElementById("userAdd");
$(document).ready(
	function() {
		var table = $('#example').DataTable(
			{
				lengthMenu: [[8, 10, 25, 50, -1],
				[8, 10, 25, 50, 'All']],
				pageLength: 8

			});
	});

	window.onload = function() {
            var showWindow = true;

            if (showWindow) {
                document.getElementById('myWindow').style.display = 'block';
            } else {
                document.getElementById('myWindow').style.display = 'none';
            }
    };





/*document.addEventListener("DOMContentLoaded", function() {
		   var hideButton = document.getElementById("checkin");
		   var showButtonMessage = document.getElementById("checkout");

		   var lastClickDate = localStorage.getItem("lastClickDate");
		   var today = new Date().toISOString().split('T')[0]; // Get the current date in YYYY-MM-DD format

		   // Check if the button was clicked today
		   if (lastClickDate === today) {
			   hideButton.style.display = "none";
			   showButtonMessage.style.display = "block";
		   } else {
			   hideButton.style.display = "block";
			   showButtonMessage.style.display = "none";
		   }

		   hideButton.addEventListener("click", function() {
			   localStorage.setItem("lastClickDate", today);
			   hideButton.style.display = "none";
			   showButtonMessage.style.display = "block";
		   });
	   });
*/


