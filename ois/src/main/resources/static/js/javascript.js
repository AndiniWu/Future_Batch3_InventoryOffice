$("#register").click(function () {
    var email= document.getElementById("email").value;
    var password=document.getElementById("password").value;
    var name=document.getElementById("name").value;
    console.log( '{"name": "' + name + '", "password": "' + password + '", "email": "'+ email +'"}');
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/registration',
        data:
            '{"name": "' + name + '", "password": "' + password + '", "email": "'+ email +'"}',
        headers: {
            "Content-Type": "application/json", "Accept": "application/json"
        },
        dataType:"json", //to parse string into JSON object,
        success: function(data, status){
            console.log("call success. result: " + data);
            alert("Success :"+data)
            //document.location.href = 'index.html'
        },
        error: function(error){
            console.log('errorCode: ' + error.status + ' . Message: ' + error.responseText);
        }
    });
});