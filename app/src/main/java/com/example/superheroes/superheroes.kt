package com.example.superheroes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.Data.SuperheroData
import com.example.superheroes.R
import com.example.superheroes.model.Superhero
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroesApp(
    modifier: Modifier =Modifier
){
    HeroesList(heroesList = SuperheroData().superhero())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesList(
    heroesList:List<Superhero>,
    modifier:Modifier =Modifier
){
    Scaffold(
        topBar = {
            HeroesTopBar()
        }
    ) {it ->
        LazyColumn(contentPadding =it,
            modifier = modifier,
        ) {
            items(heroesList){heroItem->
                HeroCard(
                    superHero = heroItem,
                    modifier =Modifier
                        .padding(dimensionResource(id = R.dimen.dimen_top))
                )
            }
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesTopBar(modifier: Modifier =Modifier){
CenterAlignedTopAppBar(title = {
    Row {
    Text(
        text = stringResource(id = R.string.title_activity_superheroes),
        style =MaterialTheme.typography.displayLarge,
        modifier =Modifier
    )
} })
}
@Composable
fun HeroText(
    name:Int,
    description:Int,
    modifier:Modifier =Modifier
){
    Column(
    ) {
        Text(
            text= stringResource(id = name),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(id = description),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroImage(
    image:Int,
    modifier: Modifier=Modifier
){
    Box(modifier = modifier){
        Image(
            painter = painterResource(id = image) ,
            contentDescription = null,
            modifier = Modifier
                .size(72.dp)
                .clip(MaterialTheme.shapes.small)
        )

    }
}

@Composable
fun HeroCard(
    superHero: Superhero,
    modifier: Modifier=Modifier
){
    Card (
        elevation =CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier =modifier,

    ){
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    dimensionResource(R.dimen.padding_all)
                )
                .clip(MaterialTheme.shapes.medium)
                .sizeIn(minHeight = 72.dp)
        ){
            HeroText(
                name = superHero.superheroName ,
                description = superHero.superheroDescriptor,
                modifier =modifier.weight(1f)
            )
            Spacer(
                modifier =Modifier
                    .width(16.dp)
            )
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.small)
            ){
                Image(
                    painter = painterResource(id = superHero.superheroImage),
                    contentDescription = stringResource(id = R.string.title_activity_superheroes),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroPreview(){
    SuperheroesTheme {
        HeroCard(
            superHero = Superhero(
                R.string.hero1,
                R.string.description1,
                R.drawable.android_superhero1
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroDarkPreview(){
    SuperheroesTheme(darkTheme = true) {
        HeroCard(
            superHero = Superhero(
                R.string.hero1,
                R.string.description1,
                R.drawable.android_superhero1
            ))
    }
}