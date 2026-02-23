package com.mudit.shopsphere.service;

import com.mudit.shopsphere.entity.CartItem;
import com.mudit.shopsphere.entity.Product;
import com.mudit.shopsphere.entity.User;
import com.mudit.shopsphere.exception.ResourceNotFoundException;
import com.mudit.shopsphere.repository.CartRepository;
import com.mudit.shopsphere.repository.ProductRepository;
import com.mudit.shopsphere.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public CartService(CartRepository cartRepository,
                       ProductRepository productRepository,
                       UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public CartItem addToCart(Long userId, Long productId, int quantity) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = new CartItem();
        cartItem.setUser(user);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        return cartRepository.save(cartItem);
    }

    public List<CartItem> getUserCart(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void removeItem(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    public void removeFromCart(Long cartItemId) {

        CartItem cartItem = cartRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Cart item not found with id: " + cartItemId));

        cartRepository.delete(cartItem);
    }

    public void updateQuantity(Long userId, Long productId, int quantity) {

        CartItem cartItem = cartRepository
                .findByUserIdAndProductId(userId, productId)
                .orElseThrow(() -> new RuntimeException("Product not in cart"));

        if (quantity <= 0) {
            cartRepository.delete(cartItem);
            return;
        }

        cartItem.setQuantity(quantity);

        cartRepository.save(cartItem);
    }
}