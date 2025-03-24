package jetbrains.kotlin.course.alias.card


import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words

@Service
class CardService {
    private val identifierFactory: IdentifierFactory = IdentifierFactory()

    // Stores list of cards
    private val cards: List<Card> = generateCards()

    companion object {
        const val WORDS_IN_CARD = 4
        val cardsAmount = words.size / WORDS_IN_CARD
    }

    // Convert each element to a Word
    private fun List<String>.toWords(): List<Word> {
        return this.map { Word(it) }
    }

    // Generate cards
    private fun generateCards(): List<Card> {
        val shuffledWords = words.shuffled() // Shuffle words
        val chunks = shuffledWords.chunked(WORDS_IN_CARD) // split words into chunks

        val cardsToGenerate = chunks.take(cardsAmount)

        // Generate a new Card for each chunk
        return cardsToGenerate.map { chunk ->
            val id = identifierFactory.uniqueIdentifier() // Generate cardID
            Card(id, chunk.toWords()) // Create card
        }
    }

    fun getCardByIndex(index: Int): Card {
        return cards[index]
    }
}
