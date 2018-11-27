import Model.*


fun main(args: Array<String>) {

    if(args.size < 2)
    {
        println("arguments invalide")
        return
    }

    var inputFile = args[0]
    var demandeur = Tp2Factory.GetEntree().Read<Demandeur>(inputFile, Demandeur::class)
    if( demandeur.client == "")
    {
        println("Fichier demandeur non trouvé")
        return
    }

    var invalideMsg = Regles.Valider(demandeur)
    if(!invalideMsg.isEmpty())
    {
        println("Fichier demandeur invalide: $invalideMsg")
        return
    }

    var benefice = Regles.Calculer(demandeur)

    var outputFile = args[1]
    try {
        Tp2Factory.GetSortie().Write(benefice, outputFile)
    }
    catch (ex: Exception)
    {
        println("Erreur d'écriture du fichier de sortie: ${ex.message}")
        return
    }
    println("Done")

}
