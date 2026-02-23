package com.mudit.shopsphere.controller;

import org.springframework.http.ResponseEntity;
import com.mudit.shopsphere.entity.CartItem;
import com.mudit.shopsphere.service.CartService;
import org.springframework.web.bind.annotation.*;
import com.mudit.shopsphere.dto.UpdateCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long userId,
                              @RequestParam Long productId,
                              @RequestParam int quantity) {

        return cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId);
    }

    @DeleteMapping("/{cartItemId}")
    public String removeItem(@PathVariable Long cartItemId) {
        cartService.removeItem(cartItemId);
        return "Item removed";
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long cartItemId) {

        cartService.removeFromCart(cartItemId);

        return ResponseEntity.ok("Item removed from cart");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCart(
            @RequestBody UpdateCartRequest request,
            @RequestParam Long userId) {

        cartService.updateQuantity(
                userId,
                request.getProductId(),
                request.getQuantity()
        );

        return ResponseEntity.ok("Cart updated successfully");
    }
}