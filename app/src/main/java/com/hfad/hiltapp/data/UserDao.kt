package com.hfad.hiltapp.data

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM users ORDER BY id DESC")
    fun getAllUsers():List<User>

    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM users")
    fun deleteTable()

    @Query("SELECT * FROM users WHERE id= :id")
    fun getUser(id: Long): User

    @Query("UPDATE users SET firstName = :firstName, lastName = :lastName, phone = :phone WHERE id =:id")
    fun editDataUser(id: Long, firstName: String, lastName: String, phone: Long)

}