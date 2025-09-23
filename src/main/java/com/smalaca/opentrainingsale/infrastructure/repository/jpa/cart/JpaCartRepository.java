package com.smalaca.opentrainingsale.infrastructure.repository.jpa.cart;

import com.smalaca.opentrainingsale.domain.cart.Cart;
import com.smalaca.opentrainingsale.domain.cart.CartRepository;
import com.smalaca.opentrainingsale.infrastructure.session.http.HttpSessionWrapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;
import java.util.UUID;

public class JpaCartRepository implements CartRepository {
    private final CrudCartRepository repository;

    JpaCartRepository(CrudCartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart findById(UUID cartId) {
        // in this bounded context Cart should already exist
        // there are two possibilities
        // - logged user - the cart was created when an account was created
        // - not logged user - the cart is created as part of the http session
        Optional<Cart> found = repository.findById(cartId);

        if (found.isPresent()) {
            return found.get();
        } else {
            return asCart(getCurrentSession());
        }
    }

    private Cart asCart(HttpSessionWrapper httpSession) {
        if (httpSession.hasNoCart()) {
            Cart cart = createCart();
            httpSession.setCart(cart);
        }

        return httpSession.getCart();
    }

    private Cart createCart() {
        return null;
    }

    private HttpSessionWrapper getCurrentSession() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession(false);
        return new HttpSessionWrapper(session);
    }

    @Override
    public void save(Cart cart) {
        repository.save(cart);
    }
}
