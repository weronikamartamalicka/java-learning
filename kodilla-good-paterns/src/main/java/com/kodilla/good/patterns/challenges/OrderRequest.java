package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public final class OrderRequest {
    private final User user;
    private final Shoe shoe;
    private final LocalDateTime time;

    public OrderRequest(final User user, final Shoe shoe, final LocalDateTime time) {
        this.user = user;
        this.shoe = shoe;
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public Shoe getProduct() {
        return shoe;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
