package io.mmaltsev.vkeducation.presentation.AppListFeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import io.mmaltsev.vkeducation.data.api.AppAPI
import io.mmaltsev.vkeducation.data.mappers.AppInfoMapper
import io.mmaltsev.vkeducation.data.mappers.AppShortMapper
import io.mmaltsev.vkeducation.data.repository.AppRepositoryImpl
import io.mmaltsev.vkeducation.domain.entities.AppShortInfo
import io.mmaltsev.vkeducation.domain.usecases.GetAppsListUseCaseImpl
import io.mmaltsev.vkeducation.presentation.Screen

import io.mmaltsev.vkeducation.presentation.ui.theme.RuStoreBlue
import io.mmaltsev.vkeducation.presentation.ui.theme.RuStoreLightBlue
import io.mmaltsev.vkeducation.presentation.utils.LoaderStatus


@Composable
fun AppListScreen(
    navController: NavController?,
    viewModel: AppListViewModel = AppListViewModel(
        getAppsListUseCase = GetAppsListUseCaseImpl(
            appRepository = AppRepositoryImpl(
                api = AppAPI(),
                appMapper = AppInfoMapper(),
                appShortMapper = AppShortMapper()
            )
        )
    )
) {
    val state: AppListState by viewModel.state.collectAsStateWithLifecycle()
    fun navigateToOtherScreen() = navController?.navigate(Screen.Detail.route)

    val snackbarHostState = remember { SnackbarHostState() }

    fun openSnackbar(appShortInfo: AppShortInfo) {
        viewModel.showIconInfo(appShortInfo)
    }

    LaunchedEffect(viewModel.events) {
        viewModel.events.collect { event ->
            when (event) {
                is AppListScreenEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    if (state.loaderStatus == LoaderStatus.LOADING) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()) {
            Text(text = "Загрузка...", fontSize = 48.sp)
        }
    } else if (state.loaderStatus == LoaderStatus.SUCCESS) {
        Scaffold(
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState,
                    snackbar = { data ->
                        Snackbar(
                            snackbarData = data,
                            containerColor = RuStoreLightBlue,
                            contentColor = Color.White,
                        )
                    }
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(RuStoreBlue)
            ) {
                AppTopMenu(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                )
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    LazyColumn(contentPadding = PaddingValues(vertical = 20.dp)) {
                        state.listCompanies.forEach { it ->
                            item {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxSize()
                                        .clickable {
                                            navigateToOtherScreen()
                                        }
                                        .padding(horizontal = 20.dp)) {
                                    Image(
                                        painter = painterResource(it.drawableLogoId),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .width(86.dp)
                                            .height(86.dp)
                                            .padding(15.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .clickable {
                                                openSnackbar(it)
                                            }

                                    )
                                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                                        Text(
                                            text = it.title,
                                            fontSize = 16.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                        Text(
                                            text = it.description,
                                            color = Color.Black,
                                            fontSize = 12.sp
                                        )
                                        Text(
                                            text = it.category,
                                            fontSize = 12.sp,
                                            color = Color.Gray
                                        )
                                    }
                                }
                                HorizontalDivider(
                                    modifier = Modifier.padding(vertical = 20.dp),
                                    thickness = DividerDefaults.Thickness,
                                    color = Color.LightGray
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun AppListScreenPreview() {
    AppListScreen(null)
}