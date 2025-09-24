package com.smalaca.opentrainingsale.infrastructure.api.rest.cart;

import com.smalaca.opentrainingsale.application.cart.CartApplicationService;
import com.smalaca.opentrainingsale.infrastructure.session.http.HttpSessionWrapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CartRestController {
    private final CartApplicationService applicationService;

    public CartRestController(CartApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public void addToCart(@RequestBody AddToCartCommand command, HttpSession httpSession) {
        UUID cartId = cartId(command, httpSession);
        applicationService.addToCart(cartId, command.trainingId());
    }

    private UUID cartId(AddToCartCommand command, HttpSession httpSession) {
        if (command.hasCardId()) {
            // user logged in
            return command.cartId();
        } else {
            // not logged in
            return new HttpSessionWrapper(httpSession).getCartId();
        }
    }
}
