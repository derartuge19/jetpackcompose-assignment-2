package com.example.todoapptrail.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapptrail.ui.screens.TodoDetailScreen
import com.example.todoapptrail.ui.screens.TodoListScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "todo_list"
    ) {
        composable("todo_list") {
            TodoListScreen(
                navController = navController,
                viewModel = hiltViewModel()
            )
        }
        
        composable(
            route = "todo_detail/{todoId}",
            arguments = listOf(navArgument("todoId") { 
                type = NavType.IntType 
                defaultValue = 0 
            })
        ) { backStackEntry ->
            TodoDetailScreen(
                navController = navController,
                viewModel = hiltViewModel()
            )
        }
        
        composable("todo_add") {
            TodoDetailScreen(
                navController = navController,
                viewModel = hiltViewModel()
            )
        }
        
        composable("todo_edit/{todoId}",
            arguments = listOf(navArgument("todoId") { 
                type = NavType.IntType 
                defaultValue = 0 
            })
        ) { backStackEntry ->
            TodoDetailScreen(
                navController = navController,
                viewModel = hiltViewModel()
            )
        }
    }
}