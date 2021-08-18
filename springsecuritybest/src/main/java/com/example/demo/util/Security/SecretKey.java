package com.example.demo.util.Security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecretKey {
    private String secretKey; // oluşturulucak keyin adını burada verildi
    private long expirationInMiliseconds; // ve tokenın ne kadar süreceği bilgisini tutacak field
}
