$(document).ready(function() {

    // Get
    function fetchData(){
        $("#list").children().remove();
        $.ajax({
                url: "http://localhost:8080/addressbook/1/buddies"
            }).then(function(data) {
                  const buddies = data._embedded.buddyinfo;
                  console.log(buddies)
                  for(let i = 0; i < buddies.length; i++) {
                      $('#list').append(`<li> Name: ${buddies[i].name} Age:${buddies[i].age} Address: ${buddies[i].address}</li>`);
                  }
            });
        }

    // POST
    $("#root").submit(function( e )  {
            e.preventDefault();
            $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "http://localhost:8080/addressbook-spa",
                    data:  JSON.stringify({
                                name: $("#Name").val(),
                               age: $("#Age").val(),
                               address: $("#Address").val()
                            }),
                    dataType: 'json',
                    cache: false,
                    complete: function () {
                      fetchData();
                    },
                    timeout: 600000})


    });

    // Fetch on first load
    fetchData();

});
