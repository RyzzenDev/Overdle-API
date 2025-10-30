package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.model.Gun;

public record ArmaSearchDTO(
        String HeroGun,
        String GunPhoto,
        String AmmoType,
        String GunType,
        Integer GunDamage,
        String Headshot,
        Integer Ammo,
        String GunSound

){
    public ArmaSearchDTO(Gun gun){
        this(
        gun.getHeroGun(),
        gun.getGunPhoto(),
        gun.getAmmoType(),
        gun.getGunType(),
        gun.getGunDamage(),
        gun.getHeadshot(),
        gun.getAmmo(),
        gun.getGunSound()
        );
    }
}
