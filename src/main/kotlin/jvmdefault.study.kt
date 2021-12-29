//@JvmDefaultWithoutCompatibility
interface Alien {
    fun originSpeak() = "biri bidi buh buh"
    //@JvmDefault
    fun humanSpeak() = "I'm Alien Interface"
}
@JvmDefaultWithoutCompatibility
class BirdPerson : Alien {
    override fun originSpeak() = "poot poot pootis pootos";
    override fun humanSpeak() = "I'm a Bird BirdPerson."
}

class DelegatedAlien(val a: Alien) : Alien by a