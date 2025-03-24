package jetbrains.kotlin.course.alias.util

typealias Identifier = Int

class IdentifierFactory {
    // Store the last unique id
    private var counter: Int = 0

    // Return next unique id
    fun uniqueIdentifier(): Identifier {
        return ++counter
    }
}
