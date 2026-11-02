import axios from 'axios';
import React, { useEffect, useState } from 'react'

interface Pokimons {
    id: number;
    name: string;
    base_experience: number;
    height: number;
    is_default: boolean;
    order: number;
    weight: number;
    abilities: Ability2[];
    past_abilities: Pastability[];
    forms: Ability[];
    game_indices: Gameindex[];
    held_items: any[];
    location_area_encounters: string;
    moves: Move[];
    species: Ability;
    sprites: Sprites;
    cries: Cries;
    stats: Stat[];
    past_stats: Paststat[];
    types: Type[];
    past_types: any[];
}

interface Type {
    slot: number;
    type: Ability;
}

interface Paststat {
    generation: Ability;
    stats: Stat[];
}

interface Stat {
    base_stat: number;
    effort: number;
    stat: Ability;
}

interface Cries {
    latest: string;
    legacy: string;
}

interface Sprites {
    other: Other;
    versions: Versions2;
    back_shiny: string;
    back_female: null;
    front_shiny: string;
    back_default: string;
    front_female: null;
    front_default: string;
    back_shiny_female: null;
    front_shiny_female: null;
}

interface Versions2 {
    'generation-i': Generationi2;
    'generation-v': Generationv;
    'generation-ii': Generationii2;
    'generation-iv': Generationiv;
    'generation-ix': Generationix;
    'generation-vi': Generationvi;
    'generation-iii': Generationiii;
    'generation-vii': Generationvii;
    'generation-viii': Generationviii;
}

interface Generationviii {
    'sword-shield': Scarletviolet;
    'legends-arceus': Legendsarceus;
    'brilliant-diamond-shining-pearl': Letsgopikachuletsgoeevee;
}

interface Legendsarceus {
    icons: Icons3;
    back_shiny: null;
    back_female: null;
    front_shiny: null;
    back_default: null;
    front_female: null;
    front_default: null;
    back_shiny_female: null;
    front_shiny_female: null;
}

interface Icons3 {
    front_shiny: null;
    front_female: null;
    front_default: null;
    front_shiny_female: null;
}

interface Generationvii {
    icons: Dreamworld;
    'ultra-sun-ultra-moon': Showdown;
    'lets-go-pikachu-lets-go-eevee': Letsgopikachuletsgoeevee;
}

interface Letsgopikachuletsgoeevee {
    icons: Redandblue;
    back_shiny: string;
    back_female: null;
    front_shiny: string;
    back_default: string;
    front_female: null;
    front_default: string;
    back_shiny_female: null;
    front_shiny_female: null;
}

interface Generationiii {
    icons: Redandblue;
    emerald: Emerald;
    'ruby-sapphire': Animated2;
    'firered-leafgreen': Animated2;
}

interface Emerald {
    animated: Animated2;
    back_shiny: string;
    front_shiny: string;
    back_default: string;
    front_default: string;
}

interface Animated2 {
    back_shiny: string;
    front_shiny: string;
    back_default: string;
    front_default: string;
}

interface Generationvi {
    'x-y': Showdown;
    icons: Dreamworld;
    'omega-ruby-alpha-sapphire': Showdown;
}

interface Generationix {
    champions: Champions;
    'legends-za': Legendsza;
    'scarlet-violet': Scarletviolet;
}

interface Scarletviolet {
    icons: Dreamworld;
    back_shiny: string;
    back_female: null;
    front_shiny: string;
    back_default: string;
    front_female: null;
    front_default: string;
    back_shiny_female: null;
    front_shiny_female: null;
}

interface Legendsza {
    icons: Home;
    back_shiny: string;
    back_female: null;
    front_shiny: string;
    back_default: string;
    front_female: null;
    front_default: string;
    back_shiny_female: null;
    front_shiny_female: null;
}

interface Champions {
    icons: Icons2;
    back_shiny: null;
    back_female: null;
    front_shiny: null;
    back_default: null;
    front_female: null;
    front_default: null;
    back_shiny_female: null;
    front_shiny_female: null;
}

interface Icons2 {
    front_shiny: null;
    front_default: null;
}

interface Generationiv {
    icons: Redandblue;
    platinum: Platinum;
    'diamond-pearl': Platinum;
    'heartgold-soulsilver': Platinum;
}

interface Platinum {
    animated: Home;
    back_shiny: string;
    back_female: null;
    front_shiny: string;
    back_default: string;
    front_female: null;
    front_default: string;
    back_shiny_female: null;
    front_shiny_female: null;
}

interface Generationii2 {
    gold: Gold;
    silver: Gold;
    crystal: Crystal;
}

interface Crystal {
    animated: Animated;
    back_shiny: string;
    front_shiny: string;
    back_default: string;
    front_default: string;
    back_transparent: string;
    front_transparent: string;
    back_shiny_transparent: string;
    front_shiny_transparent: string;
}

interface Animated {
    front_shiny: string;
    front_default: string;
}

interface Gold {
    back_shiny: string;
    front_shiny: string;
    back_default: string;
    front_default: string;
    back_transparent: string;
    front_transparent: string;
    back_shiny_transparent: string;
    front_shiny_transparent: string;
}

interface Generationv {
    icons: Icons;
    'black-white': Blackwhite;
}

interface Blackwhite {
    animated: Showdown;
    back_shiny: string;
    back_female: null;
    front_shiny: string;
    back_default: string;
    front_female: null;
    front_default: string;
    back_shiny_female: null;
    front_shiny_female: null;
}

interface Icons {
    animated: Redandblue;
    front_default: string;
}

interface Generationi2 {
    yellow: Yellow;
    'red-blue': Redblue;
    'red-green-japan': Redgreenjapan;
}

interface Redgreenjapan {
    back_gray: string;
    front_gray: string;
    back_default: string;
    front_default: string;
}

interface Redblue {
    back_gray: string;
    front_gray: string;
    back_default: string;
    front_default: string;
    back_transparent: string;
    front_transparent: string;
    back_transparent_gray: string;
    front_transparent_gray: string;
}

interface Yellow {
    back_gbc: string;
    back_gray: string;
    front_gbc: string;
    front_gray: string;
    back_default: string;
    front_default: string;
    back_transparent: string;
    front_transparent: string;
    back_transparent_gray: string;
    front_transparent_gray: string;
}

interface Other {
    home: Home;
    showdown: Showdown;
    dream_world: Dreamworld;
    'official-artwork': Officialartwork;
}

interface Officialartwork {
    versions: Versions;
    front_shiny: string;
    front_default: string;
}

interface Versions {
    'generation-i': Generationi;
    'generation-ii': Generationii;
}

interface Generationii {
    'gold-and-silver': Goldandsilver;
}

interface Goldandsilver {
    front_default: null;
}

interface Generationi {
    'red-and-blue': Redandblue;
    'red-and-green': Redandblue;
}

interface Redandblue {
    front_default: string;
}

interface Dreamworld {
    front_female: null;
    front_default: string;
}

interface Showdown {
    back_shiny: string;
    back_female: null;
    front_shiny: string;
    back_default: string;
    front_female: null;
    front_default: string;
    back_shiny_female: null;
    front_shiny_female: null;
}

interface Home {
    front_shiny: string;
    front_female: null;
    front_default: string;
    front_shiny_female: null;
}

interface Move {
    move: Ability;
    version_group_details: Versiongroupdetail[];
}

interface Versiongroupdetail {
    level_learned_at: number;
    version_group: Ability;
    move_learn_method: Ability;
    order: null | null | number;
}

interface Gameindex {
    game_index: number;
    version: Ability;
}

interface Pastability {
    generation: Ability;
    abilities: Ability3[];
}

interface Ability3 {
    is_hidden: boolean;
    slot: number;
    ability: null;
}

interface Ability2 {
    is_hidden: boolean;
    slot: number;
    ability: Ability;
}

interface Ability {
    name: string;
    url: string;
}


export interface PokemonListData {
    count: number;
    next: string;
    previous: string;
    results: Result[];
}

export interface Result {
    name: string;
    url: string;
}


type PropsCard = {
    url?: string;
}

const PokemonCards = (props: PropsCard) => {

    const [pagina, setPagina] = useState(2);
    const [pokeData, setPokeData] = useState<Pokimons>({} as Pokimons)
    const [pokemonListData, setPokemonListData] = useState<PokemonListData>({} as PokemonListData);
    const [busqueda, setbusqueda] = useState("")
    let paginaSize = 6;

    useEffect(() => {
        if (props.url) {
            tomarDatosPokemon(props.url);
        } else {
            getListaPokemon(`https://pokeapi.co/api/v2/pokemon?offset=${pagina * paginaSize}&limit=${paginaSize}`);
        }
    }, [props.url])

    async function tomarDatosPokemon(uriRecibida: string) {
        const response = await axios.get(uriRecibida);
        const pData = response.data as Pokimons;
        setPokeData(pData);
    }

    async function getListaPokemon(uriRecibida: string) {
        let response = await axios.get(uriRecibida);
        let neodata = response.data as PokemonListData;
        setPokemonListData(neodata);
    }

    function pasarPagina(numPaginas: number) {
        let paginaNueva = pagina + numPaginas;

        if (paginaNueva < 0) {
            return;
        }

        let uri = `https://pokeapi.co/api/v2/pokemon?offset=${paginaNueva * paginaSize}&limit=${paginaSize}`
        setPagina(paginaNueva);
        getListaPokemon(uri);
    }

 function cambiarBusqueda(texto: string) {
    setbusqueda(texto);

    const num = parseInt(texto);

    // Si está vacío o no es válido, vuelve a la lista paginada
    if (isNaN(num) || num < 1) {
        getListaPokemon(`https://pokeapi.co/api/v2/pokemon?offset=${pagina*paginaSize}&limit=${paginaSize}`);
        return;
    }

    getListaPokemon(`https://pokeapi.co/api/v2/pokemon?offset=${num - 1}&limit=1`);
}


    // Si recibe url: pinta la tarjeta de un Pokémon
    if (props.url) {
        return (
            <div style={{
                backgroundColor: "white",
                width: "300px",
                display: "flex",
                flexFlow: "row wrap",
                alignItems: "center",
                justifyContent: "center",
                border: "2px solid black",
                borderRadius: "10%"
            }}>
                <h2>{pokeData.name}, pokédex: </h2>
                <img style={{
                    width: "100%"
                }}
                    src={pokeData.sprites?.front_default ?? ""} />
                <p>{Math.trunc(pokeData.weight / 10)}kg {pokeData.height * 10}cm</p>
            </div>
        )
    }

    // Si no recibe url: pinta la lista con paginación
    return (
        
        <div>
            <input type="number"
        placeholder='NºPokedex'
        value={busqueda}
        onChange={(evt) => cambiarBusqueda(evt.target.value)}
        /> 
            <h3>PokemonList, página {pagina}</h3>

            <button onClick={() => pasarPagina(-1)}>Previo</button>
            <button onClick={() => pasarPagina(1)}>Siguiente</button>

            <div style={{
                display: 'grid',
                gridTemplateColumns: "1fr 1fr 1fr",
                gap: "3px"
            }}>
                {
                    pokemonListData?.results?.map(
                        (elemento) => {
                            return <PokemonCards key={elemento.name} url={elemento.url} />
                        }
                    )
                }
            </div>
        </div>
    )
}

export default PokemonCards