$(function() {
    $('#table').html(spinner)
    loadGenreTable(function(response) {
        $('#table').html(response)
    })
})