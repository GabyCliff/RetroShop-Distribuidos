package com.unla.grpc.repositories;

import com.unla.grpc.models.VirtualWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VirtualWalletRepository extends JpaRepository<VirtualWallet, Long> {

    Optional<VirtualWallet> findById(long id);

    Optional<VirtualWallet> findByIdUser(Long idUser);

}
