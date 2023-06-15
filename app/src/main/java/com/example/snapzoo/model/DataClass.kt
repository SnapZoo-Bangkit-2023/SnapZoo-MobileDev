package com.example.snapzoo.model

class DataClass {

        var image: String? = null
        var name : String? =  null
        var habitat: String? = null
        var description: String? = null
        var diet: String? = null
        var reproduction : String? = null
        var phylum : String? = null
    var genus : String? = null
    var species : String? = null
    var family : String? = null
    var _class : String? = null
    var kingdom : String? = null
    var order : String? = null

        constructor(image: String?, name: String?, habitat: String?, description: String? , diet:String? ,
        reproduction : String?, phylum : String?, genus : String?, species: String? , family : String? , _class: String?,
        kingdom : String?, order : String?){
            this.image = image
            this.name = name
            this.habitat = habitat
            this.description = description
            this.diet = diet
            this.reproduction = reproduction
            this.phylum = phylum
            this.genus = genus
            this.species = species
            this.family = family
            this._class = _class
            this.kingdom = kingdom
            this.order = order

        }
        constructor()
        {}

}