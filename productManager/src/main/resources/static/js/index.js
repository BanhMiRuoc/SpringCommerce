$(document).ready(function () {
    // Toggle form animation
    $('.message a').click(function () {
        $('.form form').animate({ height: "toggle", opacity: "toggle" }, "slow");
    });

    // Update quantity and total price in cart dynamically
    $(".quantity").each(function (id, val) {
        $(val).change(function () {
            const price = parseInt($(val).parent().siblings().eq(3).text());
            const quantity = $(val).val();
            const total = price * quantity;
            $(val).parent().siblings().eq(4).text(total);
        });
    });

    // Update cart items
    $("#update").click(function () {
        let table = $('tbody');
        $(table).children().each(function (id, val) {
            const productId = $(val).attr("id");
            const quantity = $(val).children().eq(3).children().val();
            $.ajax({
                type: 'post',
                url: '/cart/update', // Update cart endpoint
                data: { id: productId, quantity: quantity },
                success: function () {
                    $(".modal .modal-body").text("Successfully updated cart.");
                    $(".modal").modal('show');
                    setTimeout(function () {
                        $('.modal').modal('hide');
                    }, 2000);
                }
            });
        });
    });

    // Handle payment and empty cart
    // $("#pay").click(function () {
    //     $('tbody').empty();
    //     $.ajax({
    //         type: 'get',
    //         url: '/cart/checkout', // Checkout endpoint
    //         success: function () {
    //             $(".modal .modal-body").text("Payment successful.");
    //             $(".modal").modal('show');
    //             setTimeout(function () {
    //                 $('.modal').modal('hide');
    //             }, 2000);
    //         }
    //     });
    // });
});

// Add product to cart
function add(id) {
    $.ajax({
        type: 'post',
        url: '/cart/add', // Add to cart endpoint
        data: { id: id }
    }).done(function () {
        const currentCount = parseInt($("#number_product").text());
        $("#number_product").text(currentCount + 1);
    });
}

// Remove product from cart
function del(id) {
    $.ajax({
        type: 'delete',
        url: '/cart/delete', // Delete from cart endpoint
        data: { id: id },
        success: function () {
            console.log("Deleted product ID: " + id);
            $("#" + id).remove(); // Remove row from table
        }
    });
}
