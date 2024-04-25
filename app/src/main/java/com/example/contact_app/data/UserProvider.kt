package com.example.contact_app.data.model

import android.icu.text.Transliterator.Position
import com.example.contact_app.R

object UserProvider {
    private var _users: MutableList<User>
    val users: List<User> get() = _users

    init {
        _users = createDummyUsers()
    }

    fun addUser(user: User) {
        _users.add(user)
    }

    //MyPageFragment, ContactDetailFragment 수정 기능 구현중
    fun modifyUser() {
        _users
    }

    //MyPageFragment, ContactDetailFragment 삭제 기능 구현
    fun deleteUser(position: Int) {
        _users.removeAt(position)
    }

    fun switchFavoriteByUser(index: Int) {
        _users[index] = _users[index].copy(
            isFavorite = !(_users[index].isFavorite)
        )
    }

    private fun createDummyUsers(): MutableList<User> {
        val users = mutableListOf<User>()
        val firstNames = listOf("James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael", "Linda", "William", "Elizabeth")
        val lastNames = listOf("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor")
        val images = listOf(
            R.drawable.profile1, R.drawable.profile2, R.drawable.profile3, R.drawable.profile4, R.drawable.profile5,
            R.drawable.profile6, R.drawable.profile7,R.drawable.profile8, R.drawable.profile9, R.drawable.profile10
        )

        for (i in 1..30) {
            val firstName = firstNames.random()
            val lastName = lastNames.random()
            val phoneNumber = "+233 ${(1000..9999).random()} ${(10..99).random()} ${(100..999).random()}"
            val email = "${firstName.lowercase()}${lastName.lowercase()}${i}@example.com"
            val profileImage = images.random()

            val user = User(
                name = "$firstName $lastName",
                phoneNumber = phoneNumber,
                profileImage = Image.ImageDrawable(profileImage),
                email = email
            )
            users.add(user)
        }
        return users
    }
}
