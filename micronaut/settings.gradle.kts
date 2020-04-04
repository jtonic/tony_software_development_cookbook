rootProject.name = "micronaut"

include("kt:cli")
findProject(":kt:cli")?.name = "cli"
include("kt:web")
findProject(":kt:web")?.name = "web"
include("java:cli")
findProject(":java:cli")?.name = "cli"
include("java:web")
findProject(":java:web")?.name = "web"
