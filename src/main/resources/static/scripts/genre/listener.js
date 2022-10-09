$('.btn-delete').on('click', function() {
    let id = $(this).data('id')
    let href = $('#btnConfirmDelete').attr('href')
    $('#btnConfirmDelete').attr('href', href + id)
})