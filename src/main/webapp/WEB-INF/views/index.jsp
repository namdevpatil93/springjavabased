<html>
 
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<script>


function ab()
{
	var user={};
	user.id=1;
	user.name="namdev";
	
	
	
	$.ajax({
        type : "POST",
        data : JSON.stringify(user),
        contentType : "application/json",
        url: "adduser",
        dataType:"json",
        success: function (data) {
        	
        	
        },
        error: function (e) {

        }
    });	
	
	
}
ab();

</script>


hello welcome to index</body>
</html>