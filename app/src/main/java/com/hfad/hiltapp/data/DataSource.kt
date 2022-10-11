package com.hfad.hiltapp.data

import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class DataSource(private var userDao: UserDao) {

    private var ex: ExecutorService = Executors.newFixedThreadPool(6)

    private val mainThread by lazy {
        android.os.Handler(Looper.getMainLooper())
    }

    // TODO: Добавление объекта в БД
    fun addUser(user: User) {
        ex.execute {
            userDao.insertUser(User(user.firstName, user.lastname, user.phone))
        }
    }

    // TODO: Получение всех объектов из БД списком
    fun getAllUsers(callable: (List<User>) -> Unit) {
        ex.execute {
            val users = userDao.getAllUsers()
            mainThread.post {
                callable(users)
            }
        }
    }



    // TODO: Получение одного объекта из БД
//    fun getUser(callable: (User) -> Unit) {
//        ex.execute {
//            val user = userDao.getUser()
//            mainThread.post{
//                callable(user)
//            }
//        }
//    }

    // TODO: Очистка БД
    fun removeAll() {
        ex.execute {
            userDao.deleteTable()
        }
    }


    fun removeOneUser(user: User) {
        ex.execute {
            userDao.deleteUser(user)
        }
    }

    fun editOneUser(id: Long, firstName: String, lastName: String, phone: Long) {
        ex.execute {
            userDao.editDataUser(id, firstName, lastName, phone)
        }
    }
}