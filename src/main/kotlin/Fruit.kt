class FruitStand {
    private val inventory = mutableListOf<Fruit>()

    fun stock(fruit: Fruit) {
        inventory.add(fruit)
    }

    fun browse() = inventory
}

data class Fruit(val name: String, val isFresh: Boolean = true)
