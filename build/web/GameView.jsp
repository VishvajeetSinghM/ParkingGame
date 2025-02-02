<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-image: url('https://preview.redd.it/b6u6ysrgz1681.gif?width=1024&auto=webp&s=3df9c15c691f95dbe26ec5349d9845bae0c65d63');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            color: white;
        }
        .cars {
            height: 90px;
            width: 130px;
        }
table {
    
        border-collapse: collapse;
        width: 100%;
        border-left: 2px solid white;
        border-bottom: 2px solid white;
                                border-top: 3px orange dashed;


    }
    
    tr {
        border-left: 3px black dashed;
        border-right: 0; /* No border on the right */
        border-bottom: 1px solid white;

    }

    tr:last-child {
        border-bottom: 2px solid white; /* Optional: thicker bottom border for the last row */
                border-left: 3px black dashed;

    }

    td {
        height: 70px;
/*        background-image: url('https://c1.alamy.com/thumbs/2ex9g6m/pixel-minecraft-style-cobblestone-block-background-concept-of-game-pixelated-seamless-square-gray-stone-background-vector-illustration-2ex9g6m.jpg');*/
        background-image: url('https://preview.redd.it/drew-some-grass-v0-2e5rtu0ss39c1.png?auto=webp&s=873462ca7722daf8a6fba9e93a68bb4f338bfd98');
                        border-bottom: 3px orange dashed;

        padding: 10px;
        text-align: left;
    }

    td:last-child {
        background-image: url('https://st2.depositphotos.com/4196725/6839/i/450/depositphotos_68399931-stock-photo-black-old-fashioned-shapes-texture.jpg');
        border-right: 0; /* Ensures no right border for the last cell in each row */
                border-left: 3px black dashed;

    }
    div{
        align-content: center;
        padding-left:450px;
        padding-top:55px;
        padding-right:450px;

    }
     input[type="checkbox"] {
    transform: scale(3); /* Increase size by 1.5 times */
  }
  input[type="submit"] {
    transform: scale(2); /* Increase size by 1.5 times */
  }

    </style>
    <title>Lane Selection</title>
    <script>
        let selectedOrder = [];

        function captureOrder(checkbox) {
            if (checkbox.checked) {
                selectedOrder.push(checkbox.value);
            } else {
                selectedOrder = selectedOrder.filter(value => value !== checkbox.value);
            }
            document.getElementById('selectedOrder').value = selectedOrder.join(',');
            limitCheckboxSelection();
        }
        function validateSelection(event) {
        const checkboxes = document.querySelectorAll('input[name="lane"]');
        let checkedCount = 0;

        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                checkedCount++;
            }
        });

        if (checkedCount < 2) {
            alert("Please select at least two lanes before proceeding.");
            event.preventDefault(); // Prevent form submission
        }
    }

    document.addEventListener("DOMContentLoaded", function () {
        document.querySelector("form").addEventListener("submit", validateSelection);
    });


        function limitCheckboxSelection() {
            const checkboxes = document.querySelectorAll('input[name="lane"]');
            let checkedCount = 0;

            checkboxes.forEach(checkbox => {
                if (checkbox.checked) {
                    checkedCount++;
                }
            });

            checkboxes.forEach(checkbox => {
                if (checkedCount >= 2 && !checkbox.checked) {
                    checkbox.disabled = true;
                } else {
                    checkbox.disabled = false;
                }
            });
        }
    </script>
</head>
<body>
    <div>
    <form method="post" action="ParkSort">
        <center>
        <h2>Select Lanes</h2>        </center>

        <table>
            <%
                ArrayList<String> laneA = (ArrayList<String>) session.getAttribute("laneA");
                ArrayList<String> laneB = (ArrayList<String>) session.getAttribute("laneB");
                ArrayList<String> laneC = (ArrayList<String>) session.getAttribute("laneC");
                ArrayList<String> laneD = (ArrayList<String>) session.getAttribute("laneD");
                ArrayList<String> laneE = (ArrayList<String>) session.getAttribute("laneE");

                String congrats = (String) session.getAttribute("greet");

                ArrayList<String>[] lanes = new ArrayList[] {laneA, laneB, laneC, laneD, laneE};
                String[] laneNames = new String[] {"1", "2", "3", "4", "5"};

                for (int i = 0; i < lanes.length; i++) {
                    ArrayList<String> currentLane = lanes[i];
                    String laneName = laneNames[i];
            %>
            <tr>
                <td><strong><%= laneName %>:</strong></td>
                <td>
                    <% if (currentLane != null && !currentLane.isEmpty()) { %>
                        <% for (String item : currentLane) { %>
                            <%
                            if (item.equals("A")) {
                            %>
                            <img class="cars" src="${pageContext.request.contextPath}/images/carA.jpeg" alt="Description of image">
                            <%
                            } else if (item.equals("B")) {
                            %>
                            <img class="cars" src="${pageContext.request.contextPath}/images/carB.jpeg" alt="Description of image">
                            <%
                            } else if (item.equals("C")) {
                            %>
                            <img class="cars" src="${pageContext.request.contextPath}/images/carC.jpeg" alt="Description of image">
                            <%
                            }
                            %>
                        <% } %>
                    <% } %>
                </td>
                <td><input type="checkbox" name="lane" value="<%= laneName %>" onclick="captureOrder(this)"></td>
            </tr>
            <%
                }
                
            %>
        </table>

        <input type="hidden" name="selectedOrder" id="selectedOrder">
        <br>
        <center> <input type="submit" value="PARK" placeholder="Park">
       
       </center>
        <center>
       <%
if (congrats != null) {
                    out.println("<br><h1>" + congrats + "</h1><br>");
                }                
            %>
              </center>

    </form>
         </div>
        
</body>
</html>
