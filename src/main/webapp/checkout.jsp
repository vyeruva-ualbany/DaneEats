<!DOCTYPE html>
<html xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>
    <head>
        <title>Checkout</title>
        <style>
            body {
                font-family: 'arial';
            }
            #checkout-form input,
            #checkout-form button {
                display: block;
                margin: 12px;
            }
        </style>
    </head>
    <body>
        <form action='/charge' method='POST' id='checkout-form'>
            <input type='hidden' th:value='${amount}' name='amount' />
            <label>Price:<span th:text='${amount/100}' /></label>
            <!-- NOTE: data-key/data-amount/data-currency will be rendered by Thymeleaf -->
            <script
                src='https://checkout.stripe.com/checkout.js' 
                class='stripe-button'
                th:attr='data-key=${stripePublicKey},
                         data-amount=${amount},
                         data-currency=${currency}'
                
                data-description='Make your payment'
                
                data-locale='auto'
                data-zip-code='false'>
            </script>
        </form>
    </body>
</html>
