package Database

import Model.*
import contracts.IDatabase

class Repository(var contrats:Contrats, var soins: Soins, var couvertures: Couvertures): IDatabase {

    override fun Startup()
    {
        var entree = Tp2Factory.GetEntree()

        contrats = entree.Read<Contrats>("contrats.json", Contrats::class)
        soins = entree.Read<Soins>("soins.json", Soins::class)
        couvertures = entree.Read<Couvertures>("couverture.json", Couvertures::class)
    }

    override fun CouvertureOfferte(soinNum: Int, typeContrat: String): Couverture
    {
        var soin = soins.Find(soinNum)
        if(soin.id == 0)
            throw Exception("Soin num: $soinNum not found")

        var couverture = couvertures.Find(soin.id, typeContrat)
        if(couverture.soinId == 0)
            throw Exception("Couverture from soin num: $soinNum and type contrat: $typeContrat not found")

        return couverture
    }

    override fun SoinExiste(soinNum: Int): Boolean{
        var soin = soins.Find(soinNum)
        return soin.id > 0
    }

}