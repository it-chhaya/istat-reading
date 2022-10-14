const loadGenreTable = (callback) => {
    fetch(`/tmpl/genre/table`, {
        method: 'GET'
    })
    .then(response => response.text())
    .then(response => {
        if (typeof callback == 'function') {
            callback(response)
        }
    })
}