package Modules

import ResourceManager

interface ModuleAction {
    fun execute(manager: ResourceManager)
}