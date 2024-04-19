package com.hana.app.frame;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface HanaService<V, K> {
    @Transactional
    public V insert(V v);
    @Transactional
    public Optional<V> get(K k);
    @Transactional
    public List<V> get();
    public Boolean delete(K k);
    public V update(V v);

}
